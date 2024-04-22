package com.example.demo.modules.mp3;

import com.example.demo.modules.Module;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TrackArtistChecker implements Module {
    @Override
    public boolean isSupported(String format) {
        return format.endsWith(".mp3");
    }

    @Override
    public String getDescription() {
        return "Outputting artist from tags";
    }

    @Override
    public void Execute(String file) {
        try {
            AudioFile audioFile = AudioFileIO.read(new File(file));
            String title = audioFile.getTag().getFirst(FieldKey.ARTIST);
            System.out.println("Artist: " + title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
