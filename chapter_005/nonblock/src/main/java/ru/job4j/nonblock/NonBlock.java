package ru.job4j.nonblock;

import java.util.concurrent.ConcurrentHashMap;

/**
 *cache based on non-block algorithm.
 * @author Dinis Saetgareev (dinis0086@mail.ru)
 * @version 1.0
 * @since 12.06.2017
 */
public class NonBlock {
    /**
     * cache based on ConcurrentHashMap.
     */
    private ConcurrentHashMap<Integer, Task> cache = new ConcurrentHashMap();

    /**
     * adds new task.
     * @param task - new task
     */
    public void add(Task task) {
        this.cache.putIfAbsent(task.getId(), task);
    }

    /**
     * updates tasks.
     * @param id - id
     * @param task - new task
     * @return - new task or OptimisticException
     * @throws OptimisticException - exception
     */
    public Task update(int id, Task task) throws OptimisticException {
        return this.cache.computeIfPresent(id, (newId, newTask) -> {
           if (newTask.getVersion() == task.getVersion()) {
                task.versionInc();
                task.setId(id);
                return task;
           } else {
               throw new OptimisticException("Another version!");
           }
        });
    }

    /**
     * removes task.
     * @param id - id of removed task
     */
    public void delete(int id) {
        this.cache.computeIfPresent(id, (newId, newTask) -> null);
    }

    /**
     * size.
     * @return this.cache.size()
     */
    public int cacheSize() {
        return this.cache.size();
    }

}
