package com.example.pizza.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizza.SubApplication
import com.example.pizza.databinding.FragmentPizzaListBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentPizzaListBinding
    private lateinit var adapterMenu: AdapterMenu
    private lateinit var adapterCategory: AdapterCategory
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var menuViewModel: MenuViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentPizzaListBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ViewPagerAdapter(this)
        val dataPizza = (requireContext().applicationContext as SubApplication).provideDataSource()
            .getPizzaList()
        val dataCategory =
            (requireContext().applicationContext as SubApplication).provideDataSource()
                .getCategoryList()
        val inter = DataNetworkInteract(dataPizza, dataCategory)
        val viewModelFactory = PizzaListViewModelFactory(inter)
        menuViewModel =
            ViewModelProvider(this, viewModelFactory)[MenuViewModel::class.java]
        adapterMenu = AdapterMenu()
        menuViewModel.onViewCreatedPizza()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapterMenu
        adapterCategory = AdapterCategory()
        binding.recyclerViewCategory.layoutManager = LinearLayoutManager(requireContext())
        (binding.recyclerViewCategory.layoutManager as LinearLayoutManager).orientation =
            LinearLayoutManager.HORIZONTAL
        binding.recyclerViewCategory.adapter = adapterCategory
        binding.viewPager2.adapter = adapter
        initObserves()
    }

    private fun initObserves() {
        menuViewModel.loadingListCategory.observe(requireActivity()) {
            adapterCategory.setDataCategory(it)
        }
        menuViewModel.loadingListPizza.observe(requireActivity()) {
            adapterMenu.setDataPizza(it)
        }
    }
}