package nubank.codesignal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.lang.Math;

class IntegerContainerImpl implements IntegerContainer {

    private List<Integer> container = new ArrayList<>();

    public IntegerContainerImpl() {
        // TODO: implement
    }

    // TODO: implement interface methods here
    public int add(int value) {
        // default implementation
        container.add(value);
        return container.size();
    }

    public boolean delete(int value) {
        // default implementation
        if (container.contains(value)) {
            try {
                return container.remove(Integer.valueOf(value));
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public Optional<Integer> getMedian() {
        if (container.size() == 0) {
            return Optional.empty();
        }
        Optional<Integer> result = Optional.empty();
        int containerSize = container.size();
        Collections.sort(container);
        if ((containerSize % 2) == 0) {
            int index = containerSize / 2;
            result = Optional.of(container.get(index - 1));
            return result;
        } else {
            int index = Math.round(containerSize / 2);
            result = Optional.of(container.get(index));
            return result;
        }
    }
}
