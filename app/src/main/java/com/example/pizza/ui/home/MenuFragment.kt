package com.example.pizza.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizza.DataSource
import com.example.pizza.databinding.FragmentPizzaListBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentPizzaListBinding
    private lateinit var adapterMenu: AdapterMenu
    private lateinit var adapterCategory: AdapterCategory
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var dataSet: DataSource
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentPizzaListBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataSet = DataSource()
        adapter = ViewPagerAdapter(this)
        adapterMenu = AdapterMenu(dataSet.getPizzaList())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapterMenu
        adapterCategory = AdapterCategory(dataSet.getCategoryList())
        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext())
        (binding.recyclerViewCategory.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerViewCategory.adapter = adapterCategory
        binding.viewPager2.adapter = adapter
    }
}