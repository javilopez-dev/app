package com.example.javier.ui.gallery

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.javier.R
import com.example.javier.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var videoPlayer: VideoView
    private lateinit var recyclerView: RecyclerView

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Vincular el VideoView
        videoPlayer = binding.videoPlayer
        recyclerView = binding.playlistRecyclerview

        // Configurar el RecyclerView
        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        // Lista de objetos Video con los detalles de cada video
        // Lista de objetos Video con los detalles de cada video
        val videoList = listOf(
            Video(R.raw.video_1, "San Andrés", "Un recorrido por las hermosas playas de San Andrés.", "Hoy • 23 min"),
            Video(R.raw.video_1, "Curazao", "Explorando los coloridos paisajes de Curazao.", "Ayer • 12 min"),
            Video(R.raw.video_1, "Cartagena", "Historia y cultura en la mágica ciudad de Cartagena.", "Hace 2 días • 30 min")
        )


        val adapter = PlaylistAdapter(videoList) { videoResId ->
            playRawVideo(videoResId)
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun playRawVideo(videoResId: Int) {
        // Reproduce el video desde la carpeta raw usando el identificador de recurso
        val uri = Uri.parse("android.resource://${requireContext().packageName}/$videoResId")
        videoPlayer.setVideoURI(uri)
        videoPlayer.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Video(
    val videoResId: Int,        // ID del recurso del video
    val title: String,          // Título del video
    val description: String,    // Descripción del video
    val date: String            // Fecha o duración
)
