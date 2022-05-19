package ru.ama.ottest.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.util.Linkify
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.text.HtmlCompat
import ru.ama.ottest.R
import ru.ama.ottest.databinding.ActivityMainBinding
import ru.ama.ottest.databinding.ItemCoinInfoBinding
import ru.ama.ottest.databinding.ItemResultBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    setContentView(binding.root)
        if (savedInstanceState == null) {
            launchFirstScreen()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
         menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
               R.id.menu_about -> {
                  showPopupText(findViewById(R.id.menu_about),getString(R.string.ma_menu_help))
                   true
				   }
            else -> super.onOptionsItemSelected(item)
        }
    }

 

    fun showPopupText(anchor: View, txt:String) {
        val popupWindow = PopupWindow(application)
        popupWindow.animationStyle = R.style.dialog_animation_addslovoFU
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val binding2: ItemCoinInfoBinding= ItemCoinInfoBinding.inflate(layoutInflater)
        popupWindow.setBackgroundDrawable(resources.getDrawable(R.drawable.nulldr))
        binding2.tvMenuHelp.linksClickable = true
        binding2.tvMenuHelp.autoLinkMask = Linkify.WEB_URLS
        binding2.tvMenuHelp.text = HtmlCompat.fromHtml(txt,HtmlCompat.FROM_HTML_MODE_LEGACY)
        //binding2.tvMenuHelp.text=txt
        popupWindow.isFocusable = true
        popupWindow.width = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.height = WindowManager.LayoutParams.WRAP_CONTENT
        popupWindow.contentView = binding2.root
        popupWindow.showAsDropDown(anchor)

    }
 
  /*fun showAlert(titl: String, mes: String) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(titl)
            builder.setCancelable(true)
            builder.setMessage(mes)

            builder.setPositiveButton("ok") { dialogInterface, i -> dialogInterface.dismiss() }
            val dialoga = builder.create()
            dialoga.window!!.attributes .windowAnimations = R.style.dialog_animation_pd
            dialoga.show()
        }*/


    private fun launchFirstScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, ChooseTestFragment.newInstance())
            .commit()
    }
}
