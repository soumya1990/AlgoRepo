package patterns.stack;

import java.util.LinkedList;

/*
 * Given an absolute file path in a Unix-style file system, simplify it by converting ".." to the previous directory and removing any "." or multiple slashes.
 * The resulting string should represent the shortest absolute path.
 * //   /a//b////c/d//././/..
 *    cba
 */
public class SimplifyPath {

    public String simplify(String path) {
        LinkedList<String> stack = new LinkedList<>();// "/a//b////c/d//././/.."
        for (String p : path.split("/")) {
            if (!p.isEmpty() && !p.equals(".") && !p.equals("..")) {
                stack.push(p);
            } else {
                if (!stack.isEmpty() && p.equals("..")) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for (int i = stack.size()-1; i >= 0; i--) {
            sb.append(stack.get(i));
            if (i != 0) {
                sb.append("/");
            }
        }
        return sb.toString();
    }

}

// Note: Split the input by "/" and add each component to stack if not empty or
// .
// if .. then remove the top element
