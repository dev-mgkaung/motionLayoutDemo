package mk.learner.motionlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mk.learner.motionlayoutdemo.databinding.ActivityEntranceBinding

class Entrance : AppCompatActivity() {

    private lateinit var binding: ActivityEntranceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntranceBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
