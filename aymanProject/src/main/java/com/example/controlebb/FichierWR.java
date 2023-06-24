package com.example.controlebb;

import javafx.scene.control.Alert;
import com.example.controlebb.Manager;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FichierWR  {
    File file;

    public FichierWR(File file) {
        this.file = file;
    }
    public void write(Manager m) throws IOException {
        Manager nm;
        ObjectInputStream input =null;
        ObjectOutputStream output=null;
        boolean flag=false;
        File temp=new File("temp.txt");
        output=new ObjectOutputStream(new FileOutputStream(temp));
        try {
            input= new ObjectInputStream(new FileInputStream(file));
            nm=(Manager) input.readObject();
            while (nm!=null){
                if (m.ID.equals(nm.ID)){
                    output.writeObject(m);
                    flag=true;
                }
                else {
                    output.writeObject(nm);
                }
                nm=(Manager) input.readObject();

            }

        }catch (FileNotFoundException e){}
        catch (EOFException e){
            assert input != null;
            input.close();}

        catch (ClassNotFoundException e) {}
        if (!flag) output.writeObject(m);
        output.close();
        file.delete();
        temp.renameTo(file);

    }
    public Set<Manager> Read() throws IOException {
        Manager nm;
        Set<Manager> ms= new HashSet<Manager>();
        ObjectInputStream entree= new ObjectInputStream(new FileInputStream(file));
        try {
            nm=(Manager) entree.readObject();
            while (nm!=null){
                ms.add(nm);
                nm=(Manager) entree.readObject();
            }

        } catch (ClassNotFoundException e) {

        }catch  (EOFException e){
            entree.close();
        }
        return ms;


    }
}
