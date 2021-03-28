package live.erol.testcase.ui.message

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import live.erol.testcase.base.BaseFragment
import live.erol.testcase.databinding.FragmentMessagesBinding
import live.erol.testcase.extensions.goneView
import live.erol.testcase.extensions.setOnSafeClickListener
import live.erol.testcase.extensions.showView
import live.erol.testcase.utils.Resource
import live.erol.testcase.utils.autoCleared

@AndroidEntryPoint
class MessagesFragment : BaseFragment() {
    private var binding: FragmentMessagesBinding by autoCleared()
    private val viewModel: MessagesViewModel by viewModels()
    private lateinit var adapter: MessagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.listenNickname().observe(viewLifecycleOwner, Observer { nickname ->
            binding.topAppBar.title = "$nickname"
        })

        binding.topAppBar.setNavigationOnClickListener {
            if (viewModel.removeSession()) findNavController().popBackStack()
        }

        binding.messageEditText.addTextChangedListener {
            viewModel.checkMessageView(it.toString())
        }

        setupRecyclerView()

        binding.sendMessageButton.setOnSafeClickListener {
            val message = binding.messageEditText.text.toString()
            binding.messageEditText.text.clear()
            viewModel.sendMessage(message)
        }

        viewModel.getNickname()

        viewModel.listenMessageList().observe(viewLifecycleOwner, Observer {
            adapter.setMessageList(it)
        })

        viewModel.getMessagesData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Log.v("MessagesLog", "${it.data.toString()}")
                    binding.loadingBar.goneView()
                    it.data?.let { response ->
                        viewModel.setMessageList(messages = response.messages.reversed())
                    }
                }
                Resource.Status.ERROR -> {
                    Log.v("MessagesLog", "${it.message.toString()}")
                    binding.loadingBar.goneView()
                }
                Resource.Status.LOADING -> {
                    Log.v("MessagesLog", "Loading - ${it}")
                    binding.loadingBar.showView()
                }
            }
        })

        viewModel.listenMessage().observe(viewLifecycleOwner, Observer {
            adapter.addMessage(
                it,
                scrollToNewMessage = {
                    binding.messageListRecyclerView.smoothScrollToPosition(0)
                })
        })

        viewModel.listenMessageButtonState().observe(viewLifecycleOwner, Observer {
            binding.sendMessageButton.isEnabled = it
        })
    }

    private fun setupRecyclerView() {
        adapter = MessagesAdapter(viewModel.getSyncUserID())
        binding.messageListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
        binding.messageListRecyclerView.adapter = adapter
    }
}