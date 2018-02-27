##### El fragmento inicial es agregado directamente en el XML de la actividad principal:

El atributo android:name en el <fragment> especifica la clase Fragment para crear una instancia en el diseño.

Cuando el sistema crea el diseño de esta actividad, crea una instancia para cada fragmento especificado en el diseño y llama al método onCreateView() para cada uno, con el objetivo de recuperar el diseño de cada fragmento. El sistema inserta la View mostrada por el fragmento directamente en lugar del elemento <fragment>.