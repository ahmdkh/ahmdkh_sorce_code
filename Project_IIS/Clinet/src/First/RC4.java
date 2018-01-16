/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package First;

/**
 *
 * @author Rana
 */
public class RC4 {
    
     
        
        private int keylen;
        byte[] key256 = new byte[256];
        
          public RC4(byte[] key) throws Exception {
                if (key.length < 1 || key.length > 256) {
                        throw new Exception("key must be between 1 and 256 bytes");
                } else {
                    
                     for(int i=0 ; i < 256 ; i++){
                     key256[i]= 1 ;
                     //System.out.println("Initilization Key 256 = "+ key256[i]);
                     }
                     
                     int j=0;
                    for (int i=0 ; i < key.length ; i++){

                        j =  (j+  key[i]) % 255; 
                        System.out.println("J is "+ j);
                          key256[j]=key[i];

                    }
  
                    /*
                        keylen = key.length;
                        for (int i = 0; i < 256; i++) {
                                S[i] = i; //*************************
                                T[i] = key[i % keylen];
                        }
                        int j = 0;
                        for (int i = 0; i < 256; i++) {
                                j = (j + S[i] + T[i]) % 256;
                                S[i] ^= S[j];
                                S[j] ^= S[i];
                                S[i] ^= S[j];
                        }
                             */
                }
        }

    RC4() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        public byte [] encrypt(byte [] plaintext) {
                byte[] ciphertext = new byte[plaintext.length];
                int i1 = 1, j1 = 0,  iter=0;
                byte k;
             //   for (int counter = 0; counter < plaintext.length; counter++) {
                  //      i = (i + 1) % 256;
                  //      j = (j + key256[i]) % 256;
                   //     key256[i] ^= key256[j];
                   //     key256[j] ^= key256[i];
                     //   key256[i] ^= key256[j];
                        //t = (key256[i] + key256[j]) % 256;
                
                
                    iter = plaintext.length / 256;
                    if ( plaintext.length > 256){
                    for (int i=0 ; i < iter ; i++){
                        for (int j = 0; j < 256; j++) {
                            if((j+i*256) < plaintext.length){
                             k = key256[j];
                             ciphertext[j+i*256] = (byte)(plaintext[j+i*256]^ k) ;    
                            }
                        }
                       }
                    }
                    else 
                     {
                         for (int i = 0; i < 256; i++) {
                             if(i < plaintext.length){
                              k = key256[i];
                           ciphertext[i] =(byte)( plaintext[i] ^ k) ; 
                         }
                         }
                         
                     }
                  //  
                    
                   /* if(counter > 256*i1){
                        k = key256[j1];
                        ciphertext[counter] = plaintext[counter] ^ k;
                        j1++;
                    }
                    */
                    
               // }
       
                return ciphertext;
        }
        
        public byte[] decrypt(byte[] ciphertext) {
                return encrypt(ciphertext);
        }
    
}
