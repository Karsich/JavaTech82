package com.example.demo.modules.mp3;

import com.example.demo.modules.Module;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TrackDurationChecker implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".mp3");
    }

    @Override
    public String getDescription() {
        return "Output duration in seconds";
    }

    @Override
    public void Execute(String file) {
        try {
            AudioFile audioFile = AudioFileIO.read(new File(file));
            int length = audioFile.getAudioHeader().getTrackLength();
            System.out.println("Track length: " + length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
