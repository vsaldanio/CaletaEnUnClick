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
          "DESEMBARCO DEL PRIMER TELÉGRAFO",
          R.drawable.desembarco_telegrafo,
          "En Mayo de 1901, el entonces teniente de navío Ezequiel Guttero concreta su misión, al descubrir accidentalmente en esta costa, una caleta natural con restinga. A bordo del Buque ARA Guardia Nacional, traslada y desembarca los materiales destinados a la instalación del primer telégrafo. Este evento histórico, permitiría mantener comunicados a los pueblos ya existentes en el territorio de Santa Cruz, aportando además, al posterior nacimiento de la ciudad de Caleta Olivia.",
          1.2,
          "Avda. Almirante Brown 400",
          -46.4364946,
          -67.5147052
        ),
        Place(
          "VIVIENDA DE ERNESTO ROMBERG”",
          R.drawable.casaromberg,
          "Las fuentes históricas indican, que la casa de los Romberg puede haber sido la primera vivienda construida en lo que sería luego la ciudad de Caleta Olivia. Ernesto Romberg era un inmigrante alemán que llega a la zona antes de 1901, cuando aún no se habían registrado acontecimientos que permitieran vislumbrar el nacimiento de la ciudad. Al poco tiempo de haber llegado, el Sr. Romberg se casa con una mujer alemana, que acepta su propuesta de vivir en la Patagonia.  Es importante destacar que esta primera vivienda contribuyó al poblamiento de la zona, ya que los Romberg ofrecieron alojamiento a familias recién llegadas.",
          0.6,
          "Avda. Almirante Brown 441",
          -46.4363463,
          -67.5154103
        ),
        Place(
          "ALMACÉN DE JUAN ÁLVAREZ",
          R.drawable.almacenalvarez,
          "Entre los años 1930 y 1940, había sólo dos almacenes en el pueblo. En particular, este almacén surge como un emprendimiento familiar de los sevillanos Juan Álvarez y su esposa Bárbara Serrano, quienes llegan a la ciudad de Caleta Olivia en el año 1923.  En 1927, una vez que sus dos hijas Natura y Floreal alcanzan la edad escolar, la Familia Álvarez decide alquilar una vivienda a Rodolfo Martínez mientras construían la propia. A esta vivienda, conocida como “Casa Vieja”, le realizan varias mejoras y una ampliación donde instalaron este almacén. Actualmente, esta vivienda pertenece a los descendientes de la familia.",
          2.3,
          "Avda. Almirante Brown 485",
          -46.4357547,
          -67.5155297
        ),
        Place(
          "VIVIENDA DE LA FAMILIA MAIMO",
          R.drawable.casa_maimo,
          "La vivienda emplazada en este lugar conserva su fachada original casi por completo, y por ello ha sido declarada Monumento Histórico Provincial. Pedro y Juan Maimo, nacidos en la Isla de Mallorca (España), viajan a Uruguay, donde se casan con dos hermanas uruguayas: Magdalena y Eduviges Ávila, respectivamente. Pedro y Magdalena tuvieron 15 hijos y Juan y Eduviges 16 hijos, y ambas familias deciden migrar a la Patagonia, arribando a Caleta Olivia en 1911. Juan Maimo se traslada a Pico truncado, mientras que Pedro Maimo se instalan en un rancho en Caleta Olivia, hasta que logran construir su vivienda.",
          0.9,
          "Juan Álvarez 466",
          -46.4355362,
          -67.5163682
        ),
        Place(
          "ESCUELA N°14 “20 DE NOVIEMBRE”",
          R.drawable.egresados_esc14,
          "El origen de la primera escuela permanente en Caleta Olivia, se inicia con una convocatoria que realiza el Perfecto Fernández al vecindario de Bahía Laura, próxima a Puerto Deseado, donde existía una escuela ambulante que cubría la enseñanza en la región. El 22 de Septiembre de 1922, se crea la primera escuela en la ciudad, la cual ocupa un predio sobre la calle Hipólito Irigoyen (actual locación de la Empresa Servicios Públicos Sociedad del Estado). Debido al aumento explosivo de la población con el descubrimiento del petróleo en 1907 y la proyección del Plan Quinquenal Nacional para la creación de escuelas y otras instituciones, se destina un edificio y ubicación nuevos, manteniéndose hasta la actualidad.",
          0.9,
          "Juan Álvarez 263",
          -46.4357855,
          -67.5194373
        ),
        Place(
          "UBICACIÓN DEL SURTIDOR DE COMBUSTIBLE DE MÁXIMO BEREZOWSKY",
          R.drawable.bar_boliche_berezowsky,
          "Máximo Berezowsky nació en 1884 y con su hermano Gregorio, inmigraron desde Polonia a la Argentina aproximadamente en 1939. Máximo adquirió el predio y consiguió la concesión del surtidor de combustible en 1940. Mientras, su hermano Gregorio instala un taller mecánico y tornería en un terreno que lindaba en el frente de la estación de servicio YPF, en la intersección de las calles Antiguos Pobladores e Izurrastegui. Máximo falleció en Caleta Olivia en 1957 y su hermano Gregorio dos años después, pero sus descendientes aún residen en esta ciudad.",
          0.9, "Ruta 3 - Acceso Norte",
          -46.4332262,
          -67.5210711
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