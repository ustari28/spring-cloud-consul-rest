package com.alan.springcloudconsulexample.services;

import com.alan.springcloudconsulexample.dto.KeyValueConsulDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang.CharEncoding.UTF_8;

/**
 * @author Alan Dávila<br>
 * 22 Jul. 2017 19:26
 */
@Service
public class ConsulFileToDiskServiceImpl implements IConsulFileService {

    private Logger log = LoggerFactory.getLogger(ConsulFileToDiskServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;
    @Value("${spring.cloud.consul.host}")
    private String consulHost;
    @Value("${spring.cloud.consul.port}")
    private String consulPort;
    @Value("${resource.path}")
    private String targetFiles;


    @Override
    public String getFile(final String path, final String key) {
        return null;
    }

    @Override
    public List<String> getAllFiles(final String path, final String pattern, final Boolean save) {
        List<String> files = new ArrayList<>();
        StringBuilder uri = new StringBuilder();
        uri.append("http://");
        uri.append(consulHost);
        uri.append(":");
        uri.append(consulPort);
        uri.append("/v1/kv/");
        uri.append(path);

        ResponseEntity<List<String>> keys = restTemplate.exchange(uri.toString().concat("?keys"), HttpMethod.GET, null,
                new
                        ParameterizedTypeReference<List<String>>() {
                        });
        if (keys.hasBody() && keys.getStatusCode().is2xxSuccessful()) {
            validateStore();
            for (String key : keys.getBody()) {
                String[] arrays = key.split("/");
                String keyFilename = arrays[arrays.length - 1];
                if (keyFilename.contains(pattern)) {
                    ResponseEntity<List<KeyValueConsulDTO>> response = restTemplate.exchange(uri.toString().concat("/")
                            .concat
                                    (keyFilename), HttpMethod.GET, null, new ParameterizedTypeReference<List<KeyValueConsulDTO>>() {
                    });
                    if (response.hasBody() && response.getStatusCode().is2xxSuccessful()) {
                        KeyValueConsulDTO kv = response.getBody().get(0);
                        files.add(kv.getValue());
                        if (save) {
                            try {
                                FileOutputStream fos = new FileOutputStream(targetFiles.concat(keyFilename));
                                fos.write(kv.getValue().getBytes(UTF_8));
                            } catch (IOException e) {
                                log.error("It can't read the file {}", keyFilename);
                            }
                        }
                    }
                }
            }
        }
        return files;
    }

    @Override
    public void validateStore() {
        File dir = new File(targetFiles);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                log.info("Created new directory");
            } else {
                log.error("We can't create the directory {}", targetFiles);
            }
        }
    }
}
