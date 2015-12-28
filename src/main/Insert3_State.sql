USE [HealthVisAppDB]
GO

INSERT INTO [dbo].[state]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (1
           ,'New'
           ,'Patient State New'
           ,'patientStateNew')
GO

INSERT INTO [dbo].[state]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (2
           ,'Ambulant'
           ,'Patient State Ambulant'
           ,'patientStateAmbulant')
GO

INSERT INTO [dbo].[state]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (3
           ,'Stationary'
           ,'Patient State Stationary'
           ,'patientStateStationary')
GO

INSERT INTO [dbo].[state]
           ([id]
           ,[name]
           ,[description]
           ,[colourCode])
     VALUES
           (4
           ,'Archived'
           ,'Patient State Archived'
           ,'patientStateArchived')
GO