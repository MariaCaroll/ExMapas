package com.example.exmapas;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils  {


    public static boolean validate (Activity activity, int requestCode, String ... permissions)
    {
        List<String> list = new ArrayList<String>();
        for  (String permission: permissions)
        {
            boolean ok = ContextCompat.checkSelfPermission(activity, permission) ==
                    PackageManager.PERMISSION_GRANTED;
            if (! ok ) {
                list.add(permission);
                Toast.makeText(activity, "Permissao adicionada", Toast.LENGTH_SHORT).show();
            }
        }
        if (list.isEmpty()) {
            // Tudo ok, retorna true
            Toast.makeText(activity, "Permissao vazia", Toast.LENGTH_SHORT).show();
            return true;
        }

        // Lista de permissÃµes que falta acesso.
        String[] newPermissions = new String[list.size()];
        list.toArray(newPermissions);

        // Solicita permissÃ£o
        ActivityCompat.requestPermissions(activity, newPermissions, 1);

        return false;

    }

}
