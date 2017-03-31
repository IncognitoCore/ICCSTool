package nl.han.ica.icss.ast;

public class Selector extends ASTNode {
	public String tag;
	public String cls;
	public String id;

    @Override
    public String getNodeLabel() {
        return "Selector";
    }
    @Override
    public String toString() {
        // Changed this method to also return the identifier of the selector
        if(tag != null)
            return tag;
		else if(cls != null)
		    return '.' + cls;
		else
            return '#' + id;
    }
}

