package com.example.javier.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.javier.databinding.FragmentHomeBinding
import com.example.javier.R

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // Lista de imágenes
    val photoList = listOf(
        R.drawable.viaje_1,
        R.drawable.viaje_2,
        R.drawable.viaje_4,
        R.drawable.viaje_6,
        R.drawable.viaje_1,
        R.drawable.viaje_4,
        R.drawable.viaje_3,
        R.drawable.viaje_5,
        R.drawable.viaje_6,
    )

    // Lista de títulos
    val titles = listOf(
        "Playa de San Andrés",
        "Playa de Cartagena",
        "Playa de Tayrona",
        "Playa Blanca, Isla Barú",
        "Playa de El Rodadero",
        "Playa de Punta Cana",
        "Playa de Varadero",
        "Playa de Bocas del Toro",
        "Playa de Cayo Coco"
    )

    // Lista de descripciones
    val descriptions = listOf(
        "Descubre la belleza del mar Caribe en San Andrés, donde las aguas cristalinas y las arenas blancas te invitan a relajarte y disfrutar.",
        "Disfruta de las vibrantes playas de Cartagena, con su rica historia y un ambiente festivo que te hará querer quedarte más tiempo.",
        "Explora la Playa de Tayrona, un paraíso natural rodeado de exuberante vegetación y fauna exótica en la costa caribeña.",
        "Relájate en Playa Blanca, famosa por su suave arena blanca y sus aguas tranquilas, perfecta para un día de descanso.",
        "Visita El Rodadero, un destino popular en Santa Marta, ideal para disfrutar de deportes acuáticos y una vibrante vida nocturna.",
        "Conoce Punta Cana, un destino turístico que ofrece playas de ensueño, resorts de lujo y una cálida hospitalidad.",
        "Sumérgete en la belleza de Varadero, conocida por sus extensas playas y un ambiente tropical ideal para vacaciones.",
        "Descubre Bocas del Toro, un archipiélago en Panamá con playas vírgenes y un ambiente relajado, perfecto para los amantes de la naturaleza.",
        "Explora Cayo Coco, un destino de ensueño en Cuba, conocido por sus impresionantes playas y naturaleza virgen."
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Usar GridLayoutManager para dos columnas
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = PhotoAdapter(photoList, titles, descriptions, requireContext())

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
