package com.company.util;

import com.company.model.Anime;

import java.io.FileNotFoundException;
import java.util.List;

public interface IWorkWithFile {
    List<Anime> read(final String filePath) throws FileNotFoundException;
}

