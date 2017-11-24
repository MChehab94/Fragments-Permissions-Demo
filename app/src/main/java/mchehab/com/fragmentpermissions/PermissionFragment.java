package mchehab.com.fragmentpermissions;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class PermissionFragment extends Fragment {

    public PermissionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_permission, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(e-> {
            PermissionFragmentPermissionsDispatcher.readContactsWithPermissionCheck(this);
        });
        return view;
    }

    @NeedsPermission({Manifest.permission.READ_CONTACTS})
    void readContacts(){

    }

    @OnPermissionDenied({Manifest.permission.READ_CONTACTS})
    void permissionDenied(){
        Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();
    }

    @OnNeverAskAgain({Manifest.permission.READ_CONTACTS})
    void neverAskAgain(){
        Toast.makeText(getActivity(), "Never Ask again!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode,
                grantResults);
    }
}