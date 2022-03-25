package mx.tecnm.tepic.ladm_u2_ejercicio_controlhilos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import mx.tecnm.tepic.ladm_u2_ejercicio_controlhilos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hilo = HiloAdministracion(binding.mensaje)

        binding.ejecutar.setOnClickListener(){
            try {
                hilo.start()
            }catch(e:Exception){
                AlertDialog.Builder(this)
                    .setMessage("YA SE EJECUTÓ STAR PARA EL HILO")
                    .show()
            }

        }
        binding.pausar.setOnClickListener(){
            if(!hilo.estaPausado())hilo.pausarHilo()
        }
        binding.continuar.setOnClickListener(){
            if(hilo.estaPausado())hilo.despausarHilo()
        }
        binding.terminar.setOnClickListener(){
            hilo.terminarHilo()
        }
    }

}
