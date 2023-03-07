/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.negocio;

/**
 *
 * @author Ricar
 */
import java.io.File;
import org.apache.commons.net.ftp.FTP; // Nos permite indicar si transfer BINARY o ASCII
import org.apache.commons.net.ftp.FTPClient; // Para FTP plano
import org.apache.commons.net.ftp.FTPSClient; // Para FTPSecure (FTPS)
import java.io.FileInputStream; // Abrir y leer el fichero
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;

public class Subirfotos {

    public void foto(File fil) throws MalformedURLException, SmbException {
        try {
            String dest = "\\\\172.105.148.58/fotos/"+fil.getName();
            Path Destino = Paths.get(dest);
            
            String ori = fil.getPath();
            Path Origen = Paths.get(ori);
            
            Files.copy(Origen, Destino,REPLACE_EXISTING);
        } catch (Exception e) {
        }
    }
    
    public void fotoUsuarios(File fil) throws MalformedURLException, SmbException {
        try {
            String dest = "\\\\172.105.148.58/fotos/fotos_perfil_admin_y_funcionario/"+fil.getName();
            Path Destino = Paths.get(dest);
            
            String ori = fil.getPath();
            Path Origen = Paths.get(ori);
            
            Files.copy(Origen, Destino,REPLACE_EXISTING);
        } catch (Exception e) {
        }
    }

}
