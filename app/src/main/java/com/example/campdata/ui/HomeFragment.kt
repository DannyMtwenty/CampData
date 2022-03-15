package com.example.campdata.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.campdata.R

class HomeFragment : Fragment() ,View.OnClickListener{
    lateinit var navController: NavController
//    lateinit var bottomnav : BottomNavigationView
    lateinit var imgProgram : ImageView
    lateinit var imgWorkman: ImageView
    lateinit var imgLibrary: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)

//        val ContactFragment= ContactFragment()
//        setCurrentFragment(ContactFragment)


        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.kimathi1,"dkut"))
        imageList.add(SlideModel(R.drawable.kimathi2,"dkut"))
        imageList.add(SlideModel(R.drawable.kimathi3,"dkut"))
        imageList.add(SlideModel(R.drawable.kimathi4,"dkut"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)


         view.findViewById<ImageView>(R.id.img_program).setOnClickListener(this)


         view.findViewById<ImageView>(R.id.workmanimg).setOnClickListener(this)

         view.findViewById<ImageView>(R.id.imgLib).setOnClickListener(this)
         view.findViewById<ImageView>(R.id.img_dept).setOnClickListener(this)

        // view.findViewById<ImageView>(R.id.bottomNavigationView).setOnClickListener(this)
/*
        bottomnav.setOnItemSelectedListener{
            when(it.itemId){

                R.id.call->navController.navigate(R.id.contactFragment)
                R.id.locate->navController.navigate(R.id.contactFragment)

            }
            true
        }

*/




    }

//    private fun setCurrentFragment(fragment: Fragment)= supportFragmentManager.beginTransaction().apply {
//        replace(R.id.flFragment,fragment)
//        commit()
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.img_program -> navController!!.navigate(R.id.action_homeFragment_to_programFragment)
           R.id.imgLib -> navController!!.navigate(R.id.action_homeFragment_to_libraryFragment)
           R.id.workmanimg -> navController!!.navigate(R.id.action_homeFragment_to_workmanFragment)
           R.id.img_dept -> navController!!.navigate(R.id.action_homeFragment_to_departmentFragment)
       }
    }


}