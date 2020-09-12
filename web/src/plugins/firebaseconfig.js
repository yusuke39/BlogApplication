import firebase from 'firebase/app'
import 'firebase/storage'

if (!firebase.apps.length) {
  firebase.initializeApp({
    // apiKey: 'AIzaSyDxqpmFVCWkRnGsCRX6I3u170FCHjNbCso',
    apiKey: process.env.VUE_APP_FIREBASE_API_KEY,
    authDomain: process.env.VUE_APP_FIREBASE_AUTHDOMAIN,
    projectId: process.env.VUE_APP_FIREBASE_PROJECTID,
    storageBucket: process.env.VUE_APP_FIREBASE_STORAGEBUCKET,
    messagingSenderId: process.env.VUE_APP_FIREBASE_MESSAGINGSENDERID,
    appId: process.env.VUE_APP_FIREBASE_APPID,
    measurementId: process.env.VUE_APP_FIREBASE_MEASUREMENTID
  })
}

export default firebase
