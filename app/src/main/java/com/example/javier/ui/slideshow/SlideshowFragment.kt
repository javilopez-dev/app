package com.example.javier.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.javier.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        webView = binding.webview // Referencia al WebView

        // Configurar el WebView
        webView.webViewClient = WebViewClient() // Para que los enlaces se abran en el mismo WebView
        webView.loadUrl("https://www.tripadvisor.com") // URL de una página de viajes

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        webView.destroy() // Destruir el WebView al salir del fragmento
    }
}
