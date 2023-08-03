package com.example.turismo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.turismo.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val mapFragment =
            supportFragmentManager.findFragmentById(binding.generalMap.id) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        places.forEach {
            createMarker(
                LatLng(it.latitude, it.longitude),
                it.title
            )

        }

        val latLng = LatLng(-46.435640, -67.518046)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isCompassEnabled = false
            isMapToolbarEnabled = false
            isRotateGesturesEnabled=false
            isTiltGesturesEnabled=false
        }
        map.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.new_style))

    }

    private fun createMarker(latLng: LatLng, title: String) {
        val marker= map.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        )
        marker?.run {
            //setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
            Utils.getBitmapFromVector(this@MapActivity, R.drawable.place_green)?.let {
                setIcon(BitmapDescriptorFactory.fromBitmap(it))
            }
        }

    }
}