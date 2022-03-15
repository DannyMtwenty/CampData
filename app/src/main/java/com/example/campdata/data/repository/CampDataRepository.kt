package com.example.campdata.data.repository

import com.example.campdata.api.CampInterface
import com.example.campdata.data.Programs
import com.example.campdata.utils.Result
import com.example.campdata.utils.Status

class CampDataRepository (private val campInterface: CampInterface) {

    fun getAllPrograms() =campInterface.getPrograms()

    fun getAllDepartments() =campInterface.getDepartments()



}