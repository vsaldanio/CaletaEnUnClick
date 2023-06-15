package com.example.turismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.turismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.recycler.adapter = PlacesAdapter(
      listOf(
        Place(
          "Vivienda de Ernesto Romberg",
          R.drawable.wp1,
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
          1.2,
          "address",
          -46.441998,
          -67.517572
        ),
        Place(
          "Escuela N ° 14 “20 de Noviembre”",
          R.drawable.wp2,
          "description",
          0.6,
          "address",
          -34.603731,
          -58.381561
        ),
        Place(
          "Vivienda de la familia Maimo",
          R.drawable.wp3,
          "description",
          2.3,
          "address",
          -34.603731,
          -58.381561
        ),
        Place(
          "title 4",
          R.drawable.wp1,
          "description",
          0.9,
          "address",
          -34.603731,
          -58.381561
        ),
        Place(
          "title 5",
          R.drawable.wp2,
          "description",
          0.9,
          "address",
          -34.603731,
          -58.381561
        ),
        Place(
          "title 6",
          R.drawable.wp3,
          "description",
          0.9, "address",
          -34.603731,
          -58.381561
        ),
        Place(
          "title 7",
          R.drawable.wp1,
          "description",
          0.9,
          "address",
          -34.603731,
          -58.381561
        ),
      )
    ) {
      navigateTo(it)
    }
  }

  private fun navigateTo(place: Place) {
    val intent = Intent(this, DetailActivity::class.java)
    intent.putExtra(DetailActivity.EXTRA_PLACE, place)
    startActivity(intent)

  }
}