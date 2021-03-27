package live.erol.mediatopiatestcase.ui.message

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
}