package com.alan.springcloudconsulexample.services;

import java.util.List;

/**
 * @author Alan Dávila<br>
 *         22 Jul. 2017 19:07
 */

public interface IConsulFileService {

    /**
     * Get a file from consul key/value store.
     *
     * @param path Path in consul to file.
     * @param key  Filename.
     *
     * @return Content of file.
     */
    String getFile(String path, String key);

    /**
     * Get all files from a store into consul server.
     *
     * @param path    Path in consul to files.
     * @param pattern Patter of files.
     * @param save    Option to say if you want to save files to filesystem, by default is false. If you want to save
     *                it's necessary set up the property resource.path.
     *
     * @return List of content files.
     */
    List<String> getAllFiles(String path, String pattern, Boolean save);

    /**
     * Check the target store.
     */
    void validateStore();
}
