package com.mec.testejavafx.service

import com.mec.testejavafx.domain.User
import com.mec.testejavafx.domain.Vehicle

class VehicleService {

    fun getVehicle(placa: String): Vehicle? {
        val vehicles = listOf(
            Vehicle("Mini", "Cooper S", "PVC7E20", "2015", "nave demais"),
            Vehicle("BMW", "328i", "ABC5123", "2014"),
            Vehicle("Toyota", "Corolla Cross", "ADM9889", "2023"),
            Vehicle("Honda", "Civic", "GAI6822", "2017"),
        )
        return vehicles.find { it.placa == placa }
    }
}