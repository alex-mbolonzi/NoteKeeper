package com.example.notekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.notekeeper.databinding.FragmentFirst2Binding;

import java.util.List;

public class First2Fragment extends Fragment {

    private FragmentFirst2Binding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirst2Binding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        final ListView noteListView = binding.listNote;
        List<NoteInfo> noteInfoList = DataManager.getInstance().getNotes();
        ArrayAdapter<NoteInfo> noteInfoArrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, noteInfoList);
        noteListView.setAdapter(noteInfoArrayAdapter);

        noteListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getActivity(),NoteActivity.class);
            NoteInfo noteInfo = (NoteInfo) noteListView.getItemAtPosition(position);
            intent.putExtra(FirstFragment.NOTE_INFO,noteInfo);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}