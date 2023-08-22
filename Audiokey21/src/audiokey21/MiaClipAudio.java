/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package audiokey21;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * @author norser, esmepio breve clase clip
 */


public class MiaClipAudio {

    private String nomeDelFile;
    private Clip miaClip;
    public static FloatControl gainControl;

   
    public MiaClipAudio (String nome) {

        nomeDelFile = nome;
       
        try {

            File miofile = new File(nomeDelFile);
                       
            AudioInputStream inputStream;
            inputStream = AudioSystem.getAudioInputStream(miofile);

            miaClip = AudioSystem.getClip ();
            miaClip.open(inputStream);
                       
        } catch (Exception err) {
            System.out.println(err.toString());
        } // endof try-catch

    } // end of MiaClipAudio

   
    public Clip getMiaclip() {
        return miaClip;
    }

   
    public String getNomeDelFile() {
        return nomeDelFile;
    }
     
   
    public void start () {

        try {

            miaClip.start();              // qui è il play

        } catch (Exception err) {
            System.out.println(err.toString());
        }  // end of try-catch

    } // end of play


    // mode: il numero intero di loop oppure Clip.LOOP_CONTINUOUSLY

    public void loop ( int mode) {

        try {

            miaClip.loop ( mode );              // qui è il play

        } catch (Exception err) {
            System.out.println(err.toString());
        }  // end of try-catch

    } // end of loop
   
   

    public void stop () {
        try {
            if (miaClip.isOpen()) {
               
                miaClip.stop();
                miaClip.close();
            }
        } catch (Exception err) {
           System.out.println(err.toString());
        } // end of try-catch
       
    } // end of stop

    public void gain(float mygain) {
        try {
            gainControl = (FloatControl) miaClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(mygain);
        } catch (Exception err) {
            System.out.println(err.toString());
        }
    }


} // end of MiaClipAudio