package live.erol.mediatopiatestcase.ui.nickname

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import live.erol.mediatopiatestcase.base.BaseFragment
import live.erol.mediatopiatestcase.databinding.FragmentNicknameBinding
import live.erol.mediatopiatestcase.utils.autoCleared

@AndroidEntryPoint
class NicknameFragment : BaseFragment() {
    private var binding: FragmentNicknameBinding by autoCleared()
    private val viewModel: NicknameViewModel by viewModels()

}