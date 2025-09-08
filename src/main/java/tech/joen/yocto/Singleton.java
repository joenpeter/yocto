package tech.joen.yocto;

/**
 * This is a marker interface.
 * 
 * This interface denotes a component that should be initiated as a Singleton, rather than a factory.
 * Singleton means that only one instance of this specific component can exist in the application,
 * and it will thus hold state.
 */
public interface Singleton extends Component {

}
