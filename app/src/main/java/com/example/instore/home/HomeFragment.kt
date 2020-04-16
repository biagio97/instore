package com.example.instore.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.instore.R
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.instore.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home,container,false)
        val imageOfferte = listOf<Int>(
            R.drawable.offerta4,
            R.drawable.offerta1,
            R.drawable.offerta2
        )
        val adapter = OffertePagerAdapter(this.requireContext(), imageOfferte)
        binding.viewPager.adapter = adapter
        navController = findNavController()

        binding.apply {
            uomoImageView.setOnClickListener {
                goToClothes(it.contentDescription as String)
            }
            donnaImageView.setOnClickListener {
                goToClothes(it.contentDescription as String)
            }
            bambinoImageView.setOnClickListener {
                goToClothes(it.contentDescription as String)
            }
            nuoviArriviImageView.setOnClickListener {
                goToClothes(it.contentDescription as String)
            }
        }
        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.cart_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.cartItem -> navController.navigate(R.id.cartFragment)
        }
        return super.onOptionsItemSelected(item)
    }


    fun goToClothes(categoria: String){
        navController.navigate(HomeFragmentDirections.actionHomeFragmentToClothesFragment(categoria))
    }


}