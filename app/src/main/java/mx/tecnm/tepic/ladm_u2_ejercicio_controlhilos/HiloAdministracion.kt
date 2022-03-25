package mx.tecnm.tepic.ladm_u2_ejercicio_controlhilos

import android.widget.TextView

class HiloAdministracion (etiquetaEnviada : TextView) : Thread(){
    private var ejecutar = true
    private var pausar = false
    var etiquetaEnviadaGlobal = etiquetaEnviada
    val palabras = arrayOf("","Hola", "Dios", "Soy", "Yo", "De", "Nuevo", "#", "Benigno","No","Me","Repruebes")
    override fun run(){
        super.run()
        var cont =0
        while(ejecutar){
            if(!pausar){
                // SI NO (!) PAUSADO
                if (cont == palabras.size){
                    cont =0;
                }
                etiquetaEnviadaGlobal.setText(palabras[cont++])

            }


            //while(estaPausado()){
              //  etiquetaEnviadaGlobal.setText(palabras[cont])
            //}
            sleep(1000)
        }
    }
    fun terminarHilo(){
        ejecutar = false
    }
    fun pausarHilo(){
        pausar = true
    }
    fun despausarHilo(){
        pausar = false
    }
    fun estaPausado() : Boolean {
        return pausar
    }
}