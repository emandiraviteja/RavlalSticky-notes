package com.ravlal.ravlalsticky_notes;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

/**
 * Created by Raviteja Emandi on 12,June,2023
 **/

public class Data {
    Context _context;

    public Data(Context context) {
        _context = context;
    }

    public String getNotes() {
        File file = new File(_context.getFilesDir().getPath() + "/notes.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public void setNotes(String note) {
        FileOutputStream fos = null;
        try {
            fos = _context.getApplicationContext().openFileOutput("notes.txt", Context.MODE_PRIVATE);
            fos.write(note.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void deleteNotes() {
        FileOutputStream fos = null;
        try {
            fos = _context.getApplicationContext().openFileOutput("notes.txt", Context.MODE_PRIVATE);
            fos.write("".getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}