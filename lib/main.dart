import 'package:flutter/material.dart';
import 'package:messageme_app/screens/chat_screen.dart';
import 'package:messageme_app/screens/registration_screen.dart';
import 'package:messageme_app/screens/signin_screen.dart';
import 'package:messageme_app/screens/welcome_screen.dart';
import 'package:firebase_core/firebase_core.dart';
// import 'package:messageme_app/screens/registration_screen.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp();
  runApp(const MyApp());

}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'MessageMe app',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
      ),
      // home: ChatScreen(),
      initialRoute: WelcomeScreen.screenRoute,
      routes: {
        WelcomeScreen.screenRoute:(context) => WelcomeScreen(),
        SignInScreen.screenRoute:(context) => SignInScreen(),
        RegistrationScreen.screenRoute :(context) => RegistrationScreen(),
        ChatScreen.screenRoute:(context) => ChatScreen(),
      },
    );
  }
}
