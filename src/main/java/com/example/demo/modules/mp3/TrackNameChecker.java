package com.example.demo.modules.mp3;

import com.example.demo.modules.Module;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TrackNameChecker implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".mp3");
    }

    @Override
    public String getDescription() {
        return "Outputting track name from tags";
    }

    @Override
    public void Execute(String file) {
        try {
            AudioFile audioFile = AudioFileIO.read(new File(file));
            String title = audioFile.getTag().getFirst(FieldKey.TITLE);
            System.out.println("Track name: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
