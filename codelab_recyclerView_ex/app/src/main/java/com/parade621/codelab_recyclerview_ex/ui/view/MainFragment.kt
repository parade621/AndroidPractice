package com.parade621.codelab_recyclerview_ex.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.parade621.codelab_recyclerview_ex.R
import com.parade621.codelab_recyclerview_ex.data.Datasource
import com.parade621.codelab_recyclerview_ex.databinding.FragmentMainBinding
import com.parade621.codelab_recyclerview_ex.ui.adapter.RVAdapter

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myDataset = Datasource().loadAffirmations()

        val RV = binding.rvMainrv
        RV.adapter = RVAdapter( binding.root.context , myDataset)

        RV.setHasFixedSize(true)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}