package live.erol.mediatopiatestcase.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import live.erol.mediatopiatestcase.base.BaseFragment
import live.erol.mediatopiatestcase.databinding.FragmentMessagesBinding
import live.erol.mediatopiatestcase.ui.nickname.NicknameViewModel
import live.erol.mediatopiatestcase.utils.autoCleared

@AndroidEntryPoint
class MessagesFragment : BaseFragment() {
    private var binding: FragmentMessagesBinding by autoCleared()
    private val viewModel: NicknameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessagesBinding.inflate(inflater, container, false)
        return binding.root
    }
}