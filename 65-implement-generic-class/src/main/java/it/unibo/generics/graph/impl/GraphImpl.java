package it.unibo.generics.graph.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.*;

public class GraphImpl<N> implements Graph<N> {
    final private Map<N, Set<N>> nodi = new LinkedHashMap<>();
    @Override
    public void addEdge(N source, N target) {
        // TODO Auto-generated method stub
        if(nodi.containsKey(source))
            nodi.get(source).add(target);
        else
            System.out.println("angolo non esistente");
    }

    @Override
    public void addNode(N node) {
        // TODO Auto-generated method stub
        if(!nodi.containsKey(node))
            nodi.put(node , new LinkedHashSet<>());
        else
            System.out.println("nodo già contenuto");   
    }

    @Override
    public List<N> getPath(N source, N target) {
        // TODO Auto-generated method stub
        
        final List<N> s = new LinkedList<>();
        if(nodi.get(source).contains(target)){ 
            s.add(source);
            s.add(target);
            return s;
        }
            // BFS
        final LinkedList<N> queue = new LinkedList<>();
 
        final Map<N,Boolean> discovered = new HashMap<>();
        discovered.put(source, true);

        queue.add(source);
 
        while (!queue.isEmpty())
        {
            final N v = queue.removeFirst();
            s.add(v);
    
            for (final N u: nodi.get(v))
            {
                if (!discovered.containsKey(u))
                {
                    discovered.put(u, true);
                    queue.add(u);
                    if(u == target){
                        s.add(target);
                        return s;
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        // TODO Auto-generated method stub
        return nodi.get(node);
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        return new HashSet<>(nodi.keySet());
    }

    
}
