package com.example.javier.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javier.R

class PlaylistAdapter(
    private val videoList: List<Video>,  // Cambiado a una lista de Video
    private val onVideoClick: (Int) -> Unit
) : RecyclerView.Adapter<PlaylistAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoTitle: TextView = itemView.findViewById(R.id.video_title)
        val videoDescription: TextView = itemView.findViewById(R.id.video_description)
        val videoDate: TextView = itemView.findViewById(R.id.video_date)
        val playButton: ImageButton = itemView.findViewById(R.id.play_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_item, parent, false)
        return VideoViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position]  // Obtiene el objeto Video actual

        // Establece los detalles del video en las vistas correspondientes
        holder.videoTitle.text = video.title
        holder.videoDescription.text = video.description
        holder.videoDate.text = video.date

        // Configura el botón de reproducir para iniciar el video
        holder.playButton.setOnClickListener {
            onVideoClick(video.videoResId)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}
