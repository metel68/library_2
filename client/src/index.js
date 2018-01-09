import React from 'react';
import ReactDOM from 'react-dom';
import 'semantic-ui-css/semantic.min.css';
import registerServiceWorker from './registerServiceWorker';
import Routes from './routes';

ReactDOM.render(<Routes />, document.getElementById('root'));
registerServiceWorker();
