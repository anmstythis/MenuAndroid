package com.example.menuapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class FirstFragment extends Fragment {
    public Button menuText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        menuText = view.findViewById(R.id.textFromMenu);

        registerForContextMenu(menuText);

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, v.getId(), 0, "Элемент 1");
        menu.add(0, v.getId(), 1, "Элемент 2");
        menu.add(0, v.getId(), 2, "Элемент 3");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (getUserVisibleHint()) {
            switch (item.getOrder()) {
                case 0:
                    Toast.makeText(getContext(), "Элемент 1 выбран", Toast.LENGTH_SHORT).show();
                    menuText.setText(item.getTitle().toString());
                    return true;
                case 1:
                    Toast.makeText(getContext(), "Элемент 2 выбран", Toast.LENGTH_SHORT).show();
                    menuText.setText(item.getTitle().toString());
                    return true;
                case 2:
                    Toast.makeText(getContext(), "Элемент 3 выбран", Toast.LENGTH_SHORT).show();
                    menuText.setText(item.getTitle().toString());
                    return true;
                default:
                    return super.onContextItemSelected(item);
            }
        }
        return false;
    }
}