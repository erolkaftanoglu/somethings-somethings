package live.erol.mediatopiatestcase.ui.nickname

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import live.erol.mediatopiatestcase.R
import live.erol.mediatopiatestcase.base.BaseFragment
import live.erol.mediatopiatestcase.databinding.FragmentNicknameBinding
import live.erol.mediatopiatestcase.extensions.setOnSafeClickListener
import live.erol.mediatopiatestcase.utils.autoCleared

@AndroidEntryPoint
class NicknameFragment : BaseFragment() {
    private var binding: FragmentNicknameBinding by autoCleared()
    private val viewModel: NicknameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNicknameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nicknameEditText.addTextChangedListener {
            viewModel.setNickname(it.toString())
        }

        binding.setNicknameButton.setOnSafeClickListener {
            val nickname = binding.nicknameEditText.text.toString()
            if (viewModel.letsContinueWithNickname(nickname)) {
                findNavController().navigate(R.id.action_nicknameFragment_to_messagesFragment)
            } else {
                showError("local storage not supports")
            }
        }

        viewModel.listenButtonState().observe(viewLifecycleOwner, Observer { state ->
            binding.setNicknameButton.isEnabled = state
        })

        binding.setNicknameButton.isEnabled = false
    }


}