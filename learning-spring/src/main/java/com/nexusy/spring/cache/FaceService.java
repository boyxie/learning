package com.nexusy.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lan
 * @since 2016-04-25
 */
public class FaceService {

    @Cacheable(cacheNames = "faces")
    public List<Face> loadAllFaces() {
        System.out.println(Thread.currentThread().getName() + " load all faces.");
        List<Face> faces = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Face face = new Face();
            faces.add(face);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return faces;
    }

    @CachePut(cacheNames = "faces")
    public List<Face> replaceFaces() {
        System.out.println(Thread.currentThread().getName() + " replace all faces.");
        List<Face> faces = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Face face = new Face();
            face.setId(i);
            faces.add(face);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return faces;
    }

    @CacheEvict(cacheNames = "faces")
    public void removeFromCache() {
        System.out.println("clear faces from cache.");
    }

    @Cacheable(cacheNames = "face", key = "#id")
    public Face loadFaceById(int id) {
        System.out.println("face id " + id);
        Face face = new Face();
        face.setId(id);
        return face;
    }
}
