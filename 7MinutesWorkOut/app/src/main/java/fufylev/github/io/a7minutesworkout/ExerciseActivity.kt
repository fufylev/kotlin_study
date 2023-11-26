package fufylev.github.io.a7minutesworkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fufylev.github.io.a7minutesworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolBarExercise)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolBarExercise?.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}