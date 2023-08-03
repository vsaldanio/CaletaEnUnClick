package com.example.turismo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.turismo.databinding.ActivityDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class DetailActivity : AppCompatActivity(), OnMapReadyCallback {
  companion object {
    const val EXTRA_PLACE = "DetailActivity:place"
  }

  private lateinit var map: GoogleMap

  private val list = mutableListOf<CarouselItem>()

  private var latitude: Double = -34.603731
  private var longitude: Double = -58.381561
  private var title: String = "test"

  @Suppress("DEPRECATION")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.topAppBar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    val place = intent.getParcelableExtra<Place>(EXTRA_PLACE)
    binding.carousel.registerLifecycle(lifecycle)

    if (place != null) {
      binding.placeTitle.text = place.title
      binding.placeAddress.text = place.address
      binding.placeDistance.text = "${place.distance} km"
      binding.placeDescription.text = place.description

      list.add(CarouselItem(imageDrawable = R.drawable.bar_boliche_berezowsky))
      list.add(CarouselItem(imageDrawable = R.drawable.almacenalvarez))
      list.add(CarouselItem(imageDrawable = R.drawable.egresados_esc14))
      list.add(CarouselItem(imageDrawable = R.drawable.casa_maimo))
      list.add(CarouselItem(imageDrawable = R.drawable.desembarco_telegrafo))
      list.add(CarouselItem(imageDrawable = R.drawable.casaromberg))
      list.add(CarouselItem(imageDrawable = R.drawable.primer_surtidor))
      list.add(CarouselItem(imageDrawable = R.drawable.primer_surtidor_cartel))
      list.add(CarouselItem(imageDrawable = R.drawable.primer_casa_cartel))

      latitude = place.latitude
      longitude = place.longitude
      title = place.title
    }

    binding.carousel.setData(list)

    val mapFragment =
      supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
    mapFragment?.getMapAsync(this)
  }

  override fun onMapReady(googleMap: GoogleMap) {
    val latLng = LatLng(latitude, longitude)

    val marker = googleMap.addMarker(

      MarkerOptions()
        .position(latLng)
        .title(title)


    )
    if (marker != null) {
      marker.showInfoWindow()
    }
    marker?.run {
      //setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
      Utils.getBitmapFromVector(this@DetailActivity, R.drawable.place_green)?.let {
        setIcon(BitmapDescriptorFactory.fromBitmap(it))
      }
    }

    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
    googleMap.uiSettings.apply {
      isZoomControlsEnabled = true
      isCompassEnabled = false
      isMapToolbarEnabled = false
      isRotateGesturesEnabled=false
      isTiltGesturesEnabled=false
    }
    googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.new_style))
  }
}