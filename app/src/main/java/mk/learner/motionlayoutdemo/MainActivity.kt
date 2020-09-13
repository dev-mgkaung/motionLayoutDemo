package mk.learner.motionlayoutdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mk.learner.motionlayoutdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.entranceButton.setOnClickListener {
            val intent = Intent(this, Entrance::class.java)
            startActivity(intent)
        }
        binding.toolbarButton.setOnClickListener {
            val intent = Intent(this, CollapsingToolbar::class.java)
            startActivity(intent)
        }
        binding.viewPagerButton.setOnClickListener {
            val intent = Intent(this, ViewPagerIntegration::class.java)
            startActivity(intent)
        }
    }
}
