package com.ada.prospect.services;

import com.ada.prospect.models.BaseProspect;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Getter
@Service
public class QueueService {
    private final Queue<BaseProspect> queue = new LinkedList<>();

    public void addQueueItem(BaseProspect prospect) {
        queue.offer(prospect);
    }

    public BaseProspect getNextQueueItem() {
        return queue.poll();
    }

}
