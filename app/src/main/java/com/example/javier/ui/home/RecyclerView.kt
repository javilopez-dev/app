package com.example.javier.ui.home

import android.app.AlertDialog
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javier.R


class PhotoAdapter(
    private val photoList: List<Int>,
    private val titles: List<String>,
    private val descriptions: List<String>,
    private val context: Context
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val imageResId = photoList[position]

        // Cambiar el tamaño de las imágenes
        val params = holder.imageView.layoutParams
        params.height = when (position % 3) {
            0 -> 200 // Tamaño 1
            1 -> 300 // Tamaño 2
            2 -> 400 // Tamaño 3
            else -> 200
        }
        holder.imageView.layoutParams = params
        holder.imageView.setImageResource(imageResId)

        holder.itemView.setOnClickListener {
            showImageDetails(imageResId, titles[position], descriptions[position])

        }
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
    private fun showImageDetails(imageResId: Int, title: String, description: String) {
        // Usar context en lugar de requireContext()
        val builder = AlertDialog.Builder(context)
        val imageView = ImageView(context)

        // Cargar la imagen en el ImageView
        imageView.setImageResource(imageResId)
        imageView.adjustViewBounds = true

        // Crear un LinearLayout para contener la imagen y el texto
        val layout = LinearLayout(context).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
            addView(imageView)

            // Título
            val titleView = TextView(context).apply {
                text = title
                textSize = 18f
                setTypeface(null, Typeface.BOLD)
                setPadding(0, 16, 0, 8) // Espaciado
            }
            addView(titleView)

            // Descripción
            val descriptionView = TextView(context).apply {
                text = description
                textSize = 14f
                setPadding(0, 0, 0, 16) // Espaciado
            }
            addView(descriptionView)
        }

        builder.setView(layout)
            .setPositiveButton("Aceptar") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("Cancelar") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

}
